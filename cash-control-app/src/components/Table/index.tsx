const Table = () => {
  return (
    <div>
      <table className="table table-striped">
        <thead>
        <tr>
          <th scope="col">Tipo</th>
          <th scope="col">Nome</th>
          <th scope="col">Valor Previsto</th>
          <th scope="col">Valor Realizado</th>
          <th scope="col">Data</th>
          <th scope="col">Ações</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <th scope="row">Renda Ativa</th>
          <td>Salário</td>
          <td>R$ 5000,00</td>
          <td>R$ 5000,00</td>
          <td>15/05/2025</td>
          <td>
            <i className="fa-solid fa-edit m-2"></i>
            <i className="fa-solid fa-remove m-2"></i>
          </td>
        </tr>
        <tr>
          <th scope="row">Renda Passiva</th>
          <td>Dividendo</td>
          <td>R$ 5000,00</td>
          <td>R$ 5000,00</td>
          <td>15/05/2025</td>
          <td>
            <i className="fa-solid fa-edit m-2"></i>
            <i className="fa-solid fa-remove m-2"></i>
          </td>
        </tr>
        <tr>
          <th scope="row">Renda Passiva</th>
          <td>Dividendo</td>
          <td>R$ 5000,00</td>
          <td>R$ 5000,00</td>
          <td>15/05/2025</td>
          <td>
            <i className="fa-solid fa-edit m-2"></i>
            <i className="fa-solid fa-remove m-2"></i>
          </td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
          <td colSpan={5} style={{ textAlign: 'center' }}>Paginacao</td>
        </tr>
        </tfoot>
      </table>
    </div>
  );
}

export default Table;