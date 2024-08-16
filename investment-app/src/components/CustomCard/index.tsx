import './style.css';
import { Card } from 'primereact/card';

type Props = {
    title: string;
    value: string;
}

export const CustomCard = ({ title, value }: Props) => {
    return (
        <Card title={title}>
            <div className="card-body-container">
                <span className="card-body">
                    R${ value }
                </span>
            </div>
        </Card>
    );
}