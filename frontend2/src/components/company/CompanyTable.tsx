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
import Company from "../../models/Company";
import { useLoaderData } from "react-router-dom";
import { useEffect, useState } from "react";
import { getCompanies } from "../../controllers/adminController";

export default function CompanyTable() {
  // const companies = useLoaderData() as Company[];

  const [companies, setCompanies] = useState<Company[]>([]);

  useEffect(() => {
    getCompanies().then((data) => setCompanies(data));
  }, []);

  return (
    <>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Name
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Email
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Password
                </Typography>
              </TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {companies &&
              companies.map((company) => (
                <TableRow key={company.id}>
                  <TableCell variant="body" key={`name-${company.name}`}>
                    {company.name}
                  </TableCell>
                  <TableCell variant="body" key={`email-${company.id}`}>
                    {company.email}
                  </TableCell>
                  <TableCell variant="body" key={`password-${company.id}`}>
                    {company.passwordMasked}
                  </TableCell>
                </TableRow>
              ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
}
