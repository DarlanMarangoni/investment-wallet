import './style.css';
import { useEffect, useState } from 'react';
import { Income } from '../../Types/Income';
import axios from 'axios';
import { CASH_CONTROL_API_URL } from '../../services/incomeService';
import { SubmitHandler, useForm } from 'react-hook-form';
import { Receive } from '../../Types/Receive';
import Table from '../../components/Table';


const headers = [
  'Tipo',
  'Nome',
  'Valor Previsto',
  'Valor Realizado',
  'Data',
  'Ações'
];

const rows = [
  [
    'Renda Ativa',
    'Dividendo',
    'R$ 5000,00',
    '15/05/2025',
    '15/05/2025',
    ''
  ],
  [
    'Renda Ativa',
    'Salário',
    'R$ 5000,00',
    '15/05/2025',
    '15/05/2025',
    ''
  ]
];

const IncomePage = () => {

  const [incomeNameList, setIncomeNameList] = useState<Income[]>();
  const { register, handleSubmit } = useForm<Receive>();

  const onSubmit: SubmitHandler<Receive> = (data: Receive) => {
    axios.post(`${CASH_CONTROL_API_URL}/api/incomes/${data.incomeId}/receives`, data)
      .then(response => {
        const form = document.getElementById('receiveForm') as HTMLFormElement;
        form?.reset();
      })
      .catch(error => console.error(error));
  };

  useEffect(() => {
    axios.get<Income[]>(`${CASH_CONTROL_API_URL}/api/incomes`, { params: { userId: '8ca161e7-a3d6-4275-9193-32a7adfdb9a6' } })
      .then(response => {
        setIncomeNameList(response.data);
      })
      .catch(error => console.error(error));

    axios.get<Receive[]>(`${CASH_CONTROL_API_URL}/api/incomes/receives`, { params: { userId: '8ca161e7-a3d6-4275-9193-32a7adfdb9a6' } })
      .then(response => {
        console.log(response.data);
      })
      .catch(error => console.error(error));
  }, []);

  return (
    <div className="container base-card main-income">
      <h3 style={{ textAlign: 'center' }}>Cadastro de Receitas</h3>
      <form onSubmit={handleSubmit(onSubmit)} id="receiveForm">
        <div className="row">
          <div className="col-3">
            <label htmlFor="select" className="form-label">Selecione a receita</label>
            <select className="form-select" aria-label="Default select example" {...register('incomeId')}>
              <option defaultValue="">Selecione...</option>
              {incomeNameList?.map((value) => <option key={value.id} value={value.id}>{value.name}</option>)}
            </select>
          </div>
          <div className="mb-2 col-3">
            <label htmlFor="inputProjectedValue" className="form-label">Valor previsto</label>
            <input type="number" className="form-control" id="inputProjectedValue"
                   aria-describedby="valorprevisto" {...register('projected')} />
          </div>
          <div className="mb-2 col-3">
            <label htmlFor="inputActualValue" className="form-label">Valor realizado</label>
            <input type="number" className="form-control" id="inputActualValue"
                   aria-describedby="valorrealizado" {...register('actual')} />
          </div>
          <div className="mb-2 col-3">
            <label htmlFor="inputDate" className="form-label">Data</label>
            <input type="date" className="form-control" id="inputDate" aria-describedby="data" {...register('date')} />
          </div>
        </div>
        <div className="mb-2">
          <label htmlFor="textAreaDescription" className="form-label">Descrição</label>
          <textarea className="form-control" aria-label="With textarea" {...register('description')}></textarea>
        </div>
        <button type="submit" className="btn btn-primary mb-3">Salvar</button>
      </form>
      <Table headers={headers} rows={rows}/>
    </div>
  );
};

export default IncomePage;