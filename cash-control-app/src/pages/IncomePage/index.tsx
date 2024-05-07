import './style.css';
import { useEffect, useState } from 'react';
import { Income } from '../../Types/Income';
import axios from 'axios';
import { CASH_CONTROL_API_URL } from '../../services/incomeService';
import { SubmitHandler, useForm } from 'react-hook-form';
import { Receive } from '../../Types/Receive';
import List from '../../components/List';

const rows = [
  {
    description: 'Teste',
    data: '07/05/2024',
    projected: 1000.00,
    actual: 999.00,
  }
]

const IncomePage = () => {

  // const [incomeNameList, setIncomeNameList] = useState<Income[]>();
  // const { register, handleSubmit } = useForm<Receive>();
  //
  // const onSubmit: SubmitHandler<Receive> = (data: Receive) => {
  //   axios.post(`${CASH_CONTROL_API_URL}/api/incomes/${data.incomeId}/receives`, data)
  //     .then(response => {
  //       const form = document.getElementById('receiveForm') as HTMLFormElement;
  //       form?.reset();
  //     })
  //     .catch(error => console.error(error));
  // };
  //
  // useEffect(() => {
  //   axios.get<Income[]>(`${CASH_CONTROL_API_URL}/api/incomes`, { params: { userId: '8ca161e7-a3d6-4275-9193-32a7adfdb9a6' } })
  //     .then(response => {
  //       setIncomeNameList(response.data);
  //     })
  //     .catch(error => console.error(error));
  //
  //   axios.get<Receive[]>(`${CASH_CONTROL_API_URL}/api/incomes/receives`, { params: { userId: '8ca161e7-a3d6-4275-9193-32a7adfdb9a6' } })
  //     .then(response => {
  //       console.log(response.data);
  //     })
  //     .catch(error => console.error(error));
  // }, []);

  return (
    <div className="container">
      <List  rows={rows}/>
    </div>
  );
};

export default IncomePage;