import './style.css';
import 'bootstrap/js/src/collapse.js';

const pages: string[] = [
  'HOME',
  'RENDA',
  'DESPESA'
];
export default function Navbar() {
  return (
    <nav className="navbar navbar-expand-md navbar-dark bg-primary main-nav">
      <div className="container-fluid">
        <a href="link" className="nav-logo-text">
          <h4>Minhas finanças</h4>
        </a>

        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#myinvestment-navbar"
          aria-controls="myinvestment-navbar"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="myinvestment-navbar">
          <ul className="navbar-nav offset-md-2 main-menu">
            <li><a href="link" className="active">HOME</a></li>
            <li><a href="link">RENDA</a></li>
            <li><a href="link">DESPESA</a></li>
          </ul>
        </div>
      </div>
    </nav>
  );
}