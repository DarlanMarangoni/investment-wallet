import './style.css';
import Pagination from '../Pagination';
import { v4 as uuidv4 } from 'uuid';
import { Fragment } from 'react';

const Table = (props: { headers: string[]; rows: string[][] }) => {
  return (
    <div>
      <table className="table table-striped">
        <thead>
        <tr>
          {props.headers.map(header => <th scope="col" key={uuidv4()}>{header}</th>)}
        </tr>
        </thead>
        <tbody>
        {props.rows.map((row: string[]) => {
          return <tr key={uuidv4()}>{
            row.map((col: string, index: number) => {
              if (index === 0) {
                return <th scope="row" key={uuidv4()}>{col}</th>;
              }
              if (index === row.length - 1) {
                return <td key={uuidv4()}>
                  <i className="fa-solid fa-edit m-2"></i>
                  <i className="fa-solid fa-remove m-2"></i>
                </td>;
              }
              return <td key={uuidv4()}>{col}</td>
            })
          }</tr>;
        })}
        </tbody>
        <tfoot>
        <tr>
          <td colSpan={props.headers.length} style={{ padding: 0 }} key={uuidv4()}>
            <Pagination />
          </td>
        </tr>
        </tfoot>
      </table>
    </div>
  );
};

export default Table;