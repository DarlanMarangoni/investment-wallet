import './style.css';
import { CustomCard } from '../../components/CustomCard';
import { LineChart } from '../../components/LineChart';

export default function Home() {
    return (
        <div className="container">
            <div className="row">
                <div className="mt-4 col-md-6 col-lg-3">
                    <CustomCard title="Valor investido" value="10.000,00"/>
                </div>
                <div className="mt-4 col-md-6 col-lg-3">
                    <CustomCard title="Valor de mercado" value="10.000,00"/>
                </div>
                <div className="mt-4 col-md-6 col-lg-3">
                    <CustomCard title="Valor em FII" value="10.000,00"/>
                </div>
                <div className="mt-4 col-md-6 col-lg-3">
                    <CustomCard title="Valor em Ações" value="10.000,00"/>
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