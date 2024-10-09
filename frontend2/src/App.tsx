import {
  createBrowserRouter,
  createRoutesFromElements,
  RouterProvider,
  Route,
} from "react-router-dom";
import AdminLayout from "./components/layouts/AdminLayout";
import { createTheme, ThemeProvider } from "@mui/material";
import { grey, purple } from "@mui/material/colors";
import CompanyTable from "./components/company/CompanyTable";
import CustomerTable from "./components/customer/CustomerTable";
import CouponTable from "./components/coupon/CouponTable";
import { getCompanies, getCustomers } from "./controllers/adminController";
import { getCouponsByCompany } from "./controllers/companyController";
import { getCouponsByCustomer } from "./controllers/customerController";
import CompanyLayout from "./components/layouts/CompanyLayout";
import CustomerLayout from "./components/layouts/CustomerLayout";

const theme = createTheme({
  //creates a theme for all the material ui components in the project
  palette: {
    primary: purple,
    secondary: grey,
  },
  typography: {
    fontFamily: "quicksand",
  },
});

const router = createBrowserRouter(
  //creates routing structure based on paths (location) and
  //corresponding elements which it gets from function createRoutesFromElements. routs are h~~ierarchical
  createRoutesFromElements(
    //contains definitions of desired paths and elements
    <Route path="/">
      <Route path="admin" element={<AdminLayout />}>
        <Route path="company">
          <Route index element={<CompanyTable />} loader={getCompanies} />
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
  //contains themeProvider (defines design) and routerRovider (defines routing structure)
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
