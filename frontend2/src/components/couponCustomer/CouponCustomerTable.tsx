import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";
import CouponCustomer from "../../models/CouponCustomer";
import { useLoaderData } from "react-router-dom";

export default function CouponCustomerTable() {
  const couponCustomers = useLoaderData() as CouponCustomer[];
  return (
    <>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Coupon
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Customer
                </Typography>
              </TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {couponCustomers.map((couponCustomer) => (
              <TableRow key={couponCustomer.id}>
                <TableCell variant="body" key={`coupon-${couponCustomer.id}`}>
                  <Typography variant="body1">
                    {couponCustomer.couponName}
                  </Typography>
                </TableCell>
                <TableCell variant="body" key={`customer-${couponCustomer.id}`}>
                  <Typography variant="body1">
                    {couponCustomer.customerName}
                  </Typography>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
}
