import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";

const root = ReactDOM.createRoot(
  //renders the html
  document.getElementById("root") as HTMLElement
);
//app-calls app
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
