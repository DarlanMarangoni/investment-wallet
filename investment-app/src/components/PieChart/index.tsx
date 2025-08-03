import { Chart } from 'primereact/chart';
import React, { useEffect, useState } from 'react';
import { Card } from 'primereact/card';
import { Skeleton } from 'primereact/skeleton';

type Props = {
    labels: (string | undefined)[];
    values: (number | undefined)[];
    loading: boolean;
}

export const PieChart = ({labels, values, loading}: Props) => {
    const [chartData, setChartData] = useState({});
    const [chartOptions, setChartOptions] = useState({});

    console.log(loading)

    useEffect(() => {
        const documentStyle = getComputedStyle(document.documentElement);
        const data = {
            labels: labels,
            datasets: [
                {
                    data: values,
                    backgroundColor: [
                        documentStyle.getPropertyValue('--blue-500'),
                        documentStyle.getPropertyValue('--green-500')
                    ],
                    hoverBackgroundColor: [
                        documentStyle.getPropertyValue('--blue-400'),
                        documentStyle.getPropertyValue('--green-400')
                    ]
                }
            ]
        }
        const options = {
            plugins: {
                legend: {
                    labels: {
                        usePointStyle: true
                    }
                }
            }
        };

        setChartData(data);
        setChartOptions(options);
    }, [loading]);

    return (
        <Card style={{display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '580px'}} >
            {
                loading ?
                    <Chart
                        type="pie"
                        data={chartData}
                        options={chartOptions}
                        className="w-full md:w-15rem"/> :
                    <Skeleton shape="circle" size="300px"
                               />

            }
        </Card>
    )
}