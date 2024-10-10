import {
  createBrowserRouter,
  createRoutesFromElements,
  RouterProvider,
  Route,
} from "react-router-dom";
import AdminLayout from "./components/layouts/AdminLayout";
import { createTheme, ThemeProvider } from "@mui/material";
import { green, purple } from "@mui/material/colors";
import CompanyTable from "./components/company/CompanyTable";
import CustomerTable from "./components/customer/CustomerTable";
import CouponTable from "./components/coupon/CouponTable";
import {
  getCustomers,
  addCompany,
  editCompany,
} from "./controllers/adminController";
import CompanyLayout from "./components/layouts/CompanyLayout";
import CustomerLayout from "./components/layouts/CustomerLayout";
import CompanyForm from "./components/company/CompanyForm";

const theme = createTheme({
  //creates a theme for all the material ui components in the project
  palette: {
    primary: purple,
    secondary: green,
  },
  typography: {
    fontFamily: "quicksand",
  },
});

const router = createBrowserRouter(
  //creates routing structure based on paths (location) and
  //corresponding elements which it gets from function createRoutesFromElements. routs are hierarchical
  createRoutesFromElements(
    //contains definitions of desired paths and elements

    //loader: gets function and loads data from function immendiately once the page is up
    //index=means the element works as index for what comes afterwards (persists in page)
    <Route path="/">
      <Route path="admin" element={<AdminLayout />}>
        <Route path="company">
          <Route index element={<CompanyTable />} />
          <Route path="add" element={<CompanyForm onSubmit={addCompany} />} />
          <Route
            path="update/:id"
            element={<CompanyForm onSubmit={editCompany} />}
          />
        </Route>
        <Route path="customer">
          <Route index element={<CustomerTable />} loader={getCustomers} />
        </Route>
      </Route>
      <Route path="company" element={<CompanyLayout />}>
        <Route path=":companyId" element={<CouponTable />} />
      </Route>
      <Route path="customer" element={<CustomerLayout />}>
        <Route path=":customerId" element={<CouponTable />} />
      </Route>
    </Route>
  )
);

function App() {
  //contains themeProvider (defines design) a
  //and routerRovider (defines routing structure)
  return (
    <>
      <ThemeProvider theme={theme}>
        <RouterProvider router={router} />
      </ThemeProvider>
    </>
  );
}

export default App;
