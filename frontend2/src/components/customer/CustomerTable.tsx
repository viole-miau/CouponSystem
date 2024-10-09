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
import Customer from "../../models/Customer";
import { Link, useLoaderData } from "react-router-dom";

export default function CustomerTable() {
  const customers = useLoaderData() as Customer[];
  return (
    <>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  FirstName
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  LastName
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Email
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1">Password</Typography>
              </TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {customers.map((customer) => (
              <TableRow key={customer.id}>
                <TableCell
                  variant="body"
                  key={`firstName-${customer.firstName}`}
                >
                  {customer.firstName}
                </TableCell>
                <TableCell variant="body" key={`lastName-${customer.lastName}`}>
                  {customer.lastName}
                </TableCell>
                <TableCell variant="body" key={`email-${customer.id}`}>
                  {customer.email}
                </TableCell>
                <TableCell variant="body" key={`password-${customer.id}`}>
                  {customer.password}
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
}
