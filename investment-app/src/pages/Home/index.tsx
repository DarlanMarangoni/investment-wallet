import './style.css';
import { CustomCard } from '../../components/CustomCard';
import { LineChart } from '../../components/LineChart';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { Resume } from '../../types/resume';
import { BASE_URL } from '../../shared/commons';
import { Income } from '../../types/income';
import { PieChart } from '../../components/PieChart';

export default function Home() {

    const [resume, setResume] = useState<Resume>();
    const [fii, setFii] = useState<Income>();
    const [stock, setStock] = useState<Income>();

    useEffect(() => {
        axios.get(`${BASE_URL}/brockerage-note/resume`)
            .then((response) => {
                setResume(response.data)
            })
    }, [])

    useEffect(() => {
        axios.get(`${BASE_URL}/real-state-fund`)
            .then((response) => {
                console.log(response)
                setFii(response.data)
            })
    },[]);

    useEffect(() => {
        axios.get(`${BASE_URL}/stocks`)
            .then((response) => {
                console.log(response)
                setStock(response.data)
            })
    },[]);


    return (
        <div className="container">
            <div className="row">
                <div className="mt-4 col-md-6 col-lg-3">
                    <CustomCard title="Valor investido" value={resume?.invested_value}/>
                </div>
                <div className="mt-4 col-md-6 col-lg-3">
                    <CustomCard title="Valor de mercado" value={resume?.current_value}/>
                </div>
                <div className="mt-4 col-md-6 col-lg-3">
                    <CustomCard title="Valor em FII" value={fii?.total}/>
                </div>
                <div className="mt-4 col-md-6 col-lg-3">
                    <CustomCard title="Valor em Ações" value={stock?.total}/>
                </div>
            </div>
            <div className="row">
                <div className="col-lg-6 mt-4">
                    <LineChart/>
                </div>
                <div className="col-lg-6 mt-4">
                    <PieChart labels={[stock?.type, fii?.type]} values={[stock?.total, fii?.total]}
                              loading={fii !== undefined && stock !== undefined}/>
                </div>
            </div>
        </div>

    );
}