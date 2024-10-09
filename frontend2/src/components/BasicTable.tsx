import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import Company from "../models/Company";
import { Typography } from "@mui/material";

// <T extends Company | Customer | Coupon>
type BasicTableProps = {
  data: Company[];
};

export default function BasicTable(props: BasicTableProps) {
  const columnNames: String[] = Object.getOwnPropertyNames(props.data[0]);

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            {columnNames.map((columnName) => (
              <TableCell variant="head">
                <Typography variant="body1">{columnName}</Typography>
              </TableCell>
            ))}
          </TableRow>
        </TableHead>
        <TableBody>
          {props.data.map((row) => (
            <TableRow key={row.id}>
              {Object.entries(row).map((key, value) => (
                <TableCell variant="body" key={`${key}+${value}`}>
                  <Typography variant="body2">{value}</Typography>
                </TableCell>
              ))}
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
