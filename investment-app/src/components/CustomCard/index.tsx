import './style.css';
import { Card } from 'primereact/card';
import { Skeleton } from 'primereact/skeleton';

type Props = {
    title: string;
    value: number | undefined;
    loading: boolean;
}

export const CustomCard = ({title, value, loading}: Props) => {
    return (
        <Card title={title}>
            {
                loading ?
                    <span className="card-body">
                        {value?.toLocaleString('pt-br', {style: 'currency', currency: 'BRL'})}
                    </span> :
                    <Skeleton width="16rem" height="2rem"></Skeleton>
            }

        </Card>
    );
}