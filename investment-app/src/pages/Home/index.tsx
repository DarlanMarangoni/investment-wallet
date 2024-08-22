import './style.css';
import { CustomCard } from '../../components/CustomCard';
import { LineChart } from '../../components/LineChart';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { Resume } from '../../types/resume';
import { BASE_URL } from '../../shared/commons';
import { Income } from '../../types/income';

export default function Home() {

    const [resume, setResume] = useState<Resume>();
    const [fii, setFii] = useState<Income>();
    const [stock, setStock] = useState<Income>();

    useEffect(() => {
        axios.get(`${BASE_URL}/brockerage-note/resume`)
            .then((response) => {
                setResume(response.data)
            })
        axios.get(`${BASE_URL}/real-state-fund`)
            .then((response) => {
                setFii(response.data)
            })
        axios.get(`${BASE_URL}/stocks`)
            .then((response) => {
                setStock(response.data)
            })
    }, [])

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
            <div className="row mt-4">
                <div className="col-lg-6">
                    <LineChart/>
                </div>
                <div className="col-lg-6">
                    <LineChart/>
                </div>
            </div>
        </div>

    );
}