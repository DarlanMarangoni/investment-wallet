import './style.css';
import { Card } from 'primereact/card';

type Props = {
    title: string;
    value: number | undefined;
}

export const CustomCard = ({title, value}: Props) => {
    return (
        <Card title={title}>
            <span className="card-body">
                {value?.toLocaleString('pt-br',{style: 'currency', currency: 'BRL'})}
            </span>
        </Card>
    );
}