import './style.css';
import { useEffect, useState } from 'react';
import { Income } from '../../Types/Income';
import axios from 'axios';
import { CASH_CONTROL_API_URL } from '../../services/incomeService';

const IncomePage = () => {

  const [incomes, setIncomes] = useState<Income[]>();

  useEffect(() => {
    axios.get<Income[]>(`${CASH_CONTROL_API_URL}/api/incomes`, { params: { userId: '8ca161e7-a3d6-4275-9193-32a7adfdb9a6' } })
      .then(response => {
        setIncomes(response.data);
      })
      .catch(error => console.error(error));
  }, []);

  return (
    <div className="container base-card pb-2 pt-2 main-income">
      <h1>Cadastro de Receitas</h1>
      <form>
        <div className="row">
          <div className="col-3">
            <label htmlFor="select" className="form-label">Selecione a receita</label>
            <select className="form-select" aria-label="Default select example">
              <option defaultValue="">Selecione...</option>
              {incomes?.map((value, index) => <option key={index} value={value.name}>{value.name}</option>)}
            </select>
          </div>
          <div className="mb-2 col-3">
            <label htmlFor="inputProjectedValue" className="form-label">Valor previsto</label>
            <input type="number" className="form-control" id="inputProjectedValue" aria-describedby="valorprevisto" />
          </div>
          <div className="mb-2 col-3">
            <label htmlFor="inputActualValue" className="form-label">Valor realizado</label>
            <input type="number" className="form-control" id="inputActualValue" aria-describedby="valorrealizado" />
          </div>
          <div className="mb-2 col-3">
            <label htmlFor="inputDate" className="form-label">Data</label>
            <input type="date" className="form-control" id="inputDate" aria-describedby="data" />
          </div>
        </div>
        <div className="mb-2">
          <label htmlFor="textAreaDescription" className="form-label">Descrição</label>
          <textarea className="form-control" aria-label="With textarea"></textarea>
        </div>
        <button type="submit" className="btn btn-primary mb-3">Salvar</button>
      </form>
    </div>
  );
};

export default IncomePage;