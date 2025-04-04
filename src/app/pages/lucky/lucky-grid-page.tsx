"use client"

import React, {useState, useRef, useEffect} from 'react'
// @ts-ignore
import {LuckyGrid} from '@lucky-canvas/react'
import {queryRaffleAwardList, randomRaffle} from "@/apis";
import {RaffleAwardVO} from "@/types/RaffleAwardVO";
import {root} from "postcss";
import {info} from "next/dist/build/output/log";
import {it} from "node:test";

type ProcessedPrizes = {
    background: string;
    x: number;
    y: number;
    fonts: Array<{id?: number, text: string, top: string}>
    isThank?: boolean;
}

export function LuckyGridPage() {
    // 定义填充路径的坐标顺序
    const path = [
        [0, 0], [0, 1], [0, 2], // 上边行
        [1, 2], [2, 2],         // 右边列
        [2, 1], [2, 0],         // 下边行（从右到左）
        [1, 0]                  // 左边列（从下到上）
    ];

    // 背景
    const [blocks] = useState([
        {padding: '10px', background: '#869cfa'}
    ])

    const [prizes, setPrizes] = useState([
    ])

    const [buttons] = useState([
        {x: 1, y: 1, background: "#7f95d1", fonts: [{text: '开始', top: '40%'}]}
    ])

    const [defaultStyle] = useState([{background: "#b8c5f2"}])

    // 预处理奖品数据
    // @ts-ignore
    const processAwards = (data: RaffleAwardVO[]): ProcessedPrizes[] => {
        // 处理不同长度情况
        // @ts-ignore
        let processedData: (RaffleAwardVO | null)[] = JSON.parse(JSON.stringify(data));
        const originalLength = data.length;
        if ([2, 4].includes(originalLength)) {
            const repeatTimes = 8 / originalLength;
            processedData = [];
            for (let i = 0; i < repeatTimes; i++) {
                processedData = insertRandomly(processedData, data);
            }
        } else if (originalLength === 3) {
            processedData = [...data, ...data];
            const thanksNeeded = 8 - processedData.length;
            processedData = insertRandomly(processedData, Array(thanksNeeded).fill(null));
        } else if (originalLength > 4 && originalLength < 8) {
            const thanksNeeded = 8 - originalLength;
            processedData = insertRandomly(processedData, Array(thanksNeeded).fill(null));
        } else if (originalLength < 8) {
            const thanksNeeded = 8 - originalLength;
            processedData = insertRandomly(processedData, Array(thanksNeeded).fill(null));
        }
        // @ts-ignore
        return path.map(([x, y], index) => {
            // @ts-ignore
            const award = processedData[index]
            const isEven = index % 2 === 0;

            if (!award) {
                return {
                    background: '#d9d9d9',
                    x,
                    y,
                    fonts: [{text: '谢谢参与', top: '30%'}],
                    isThankYou: true
                }
            };

            return {
                background: isEven ? '#e9e8fe' : '#b8c5f2',
                x,
                y,
                fonts: [{
                    id: award.awardId,
                    text: award.awardTitle,
                    top: '30%'
                }]
            }
        });
    }

    // 随机插入函数
    const insertRandomly = <T,> (base:T[], items: T[]): T[] => {
        const newArray = [...base];
        items.forEach(items => {
            const randomIndex = Math.floor(Math.random() * (newArray.length + 1));
            newArray.splice(randomIndex, 0, items);
        });
        return newArray
    }

    // 查询奖品列表
    const queryRaffleAwardListHandle = async () => {
        const queryParams = new URLSearchParams(window.location.search);
        const strategyId = Number(queryParams.get('strategyId'));
        const result = await queryRaffleAwardList(strategyId);
        const {code, info, data} = await result.json();
        if (code != "0000") {
            window.alert("获取抽奖奖品列表失败 code:" + code + " info:" + info)
            return;
        }
        console.log("data长度" + data.length)
        // @ts-ignore
        const processedPrizes = processAwards(data);
        setPrizes(processedPrizes)
        // let a = 0, b = 0;
        // const i = Math.floor(8 / data.length);
        // console.log(data)
        // // 创建一个新的奖品数组
        //     let prizes = data.map((award: RaffleAwardVO, index: number) => {
        //         const background = index % 2 === 0 ? '#e9e8fe' : '#b8c5f2';
        //         if (index > 8) {
        //             return
        //         }
        //         [a, b] = path[index]
        //         console.log("a:" + a + "b:" + b)
        //         return {
        //             background: background,
        //             x: a,
        //             y: b,
        //             fonts: [{id: award.awardId, text: award.awardTitle, top: '40px'}]
        //             // {x: 0, y: 0, fonts: [{text: 'A', top: '35%'}]},
        //         };
        //     });
        //
        // console.log(prizes)
        // // 设置奖品数据
        // setPrizes(prizes)
    }

    // 调用随机抽奖
    const randomRaffleHandle = async () => {
        const queryParams = new URLSearchParams(window.location.search);
        const strategyId = Number(queryParams.get('strategyId'));
        const result = await randomRaffle(strategyId);
        const {code, info, data} = await result.json();
        if (code != "0000") {
            window.alert("随机抽奖失败 code:" + code + " info:" + info)
            return;
        }
        // 为了方便测试，mock 的接口直接返回 awardIndex 也就是奖品列表中第几个奖品。
        return data.awardIndex - 1;
    }

    useEffect(() => {
        queryRaffleAwardListHandle().then(r => {
        });
    }, [])

    // @ts-ignore
    const myLucky = useRef()

    return <>
        <LuckyGrid
            ref={myLucky}
            width="300px"
            height="300px"
            rows="3"
            cols="3"
            prizes={prizes}
            defaultStyle={defaultStyle}
            buttons={buttons}
            onStart={() => { // 点击抽奖按钮会触发star回调
                // @ts-ignore
                myLucky.current.play()
                setTimeout(() => {
                    // 抽奖接口
                    randomRaffleHandle().then(prizesIndex => {
                        // @ts-ignore
                        myLucky.current.stop(prizesIndex)
                    });
                }, 2500)
            }}
            onEnd={
                // @ts-ignore
                prize => {
                    alert('恭喜你抽到【' + prize.fonts[0].text + '】奖品ID【' + prize.fonts[0].id + '】')
                }
            }>

        </LuckyGrid>
    </>

}