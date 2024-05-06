import "./style.css"
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
        <tr >
          <td colSpan={6} style={{padding: 0}}>
            <nav aria-label="Page navigation example">
              <ul className="pagination" style={{ justifyContent: 'center', margin: 0 }}>
                <li className="page-item">
                  <a className="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </li>
                <li className="page-item"><a className="page-link" href="#">1</a></li>
                <li className="page-item"><a className="page-link" href="#">2</a></li>
                <li className="page-item"><a className="page-link" href="#">3</a></li>
                <li className="page-item">
                  <a className="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>
              </ul>
            </nav>
          </td>
        </tr>
        </tfoot>
      </table>
    </div>
  );
}

export default Table;