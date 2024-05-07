import Modal from '../Modal';
import { v4 as uuidv4 } from 'uuid';

const List = (props: { rows: any[] }) => {
  return <>
    <ul className="list-group list-group-flush">
      {props.rows.map(row => <li className="list-group-item d-flex justify-content-between align-items-center"
                                 key={uuidv4()}>
        <div>
          <div className="fw-bold">{row.description}</div>
          <div><span className="fw-bold">data:</span> {row.data}</div>
          <div><span className="fw-bold">valor previsto:</span> R$ {row.projected}</div>
          <div><span className="fw-bold">valor realizado:</span> R$ {row.actual}</div>
        </div>
        <button type="button" className="btn btn-link" onClick={() => alert()}>
          <i className="fa fa-2xl fa-ellipsis-v"></i>
        </button>
      </li>)}
    </ul>
    <div>
      <Modal />
    </div>
  </>;
};

export default List;