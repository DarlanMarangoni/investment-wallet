import './style.css';
import { CustomCard } from '../../components/CustomCard';
import { LineChart } from '../../components/LineChart';

export default function Home() {
    return (
        <div>
            <div className="home-container">
                <div className="home-card-container">
                    <CustomCard title="Valor investido" value="10.000,00"/>
                </div>
                <div className="home-card-container">
                    <CustomCard title="Valor de mercado" value="10.000,00"/>
                </div>
                <div className="home-card-container">
                    <CustomCard title="Valor em FII" value="10.000,00"/>
                </div>
                <div className="home-card-container">
                    <CustomCard title="Valor em Ações" value="10.000,00"/>
                </div>
            </div>
            <div className="home-char-container">
                <LineChart/>
            </div>
        </div>

    );
}