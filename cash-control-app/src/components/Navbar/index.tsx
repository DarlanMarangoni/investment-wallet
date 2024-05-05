
const pages: string[]  = [
  "HOME",
  "RENDA",
  "DESPESA"
];
export default function Navbar() {
  return (
    <nav className="bg-primary">
      <div>
        <a href="link">
          <h4>Minhas finanças</h4>
        </a>
        <div>
          <ul>
            {pages.map(page => <li><a href="link">{page}</a></li>)}
          </ul>
        </div>
      </div>
    </nav>
  );
}