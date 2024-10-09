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
import Coupon from "../../models/Coupon";
import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { getCouponsByCompany } from "../../controllers/companyController";
import { getCouponsByCustomer } from "../../controllers/customerController";

export default function CouponTable() {
  const { customerId, companyId } = useParams();
  const [coupons, setCoupons] = useState<Coupon[]>([]);
  useEffect(() => {
    if (customerId) {
      getCouponsByCustomer(Number(customerId))
        .then((data) => data && setCoupons(data))
        .catch((err) => console.error(err));
    }
    if (companyId) {
      getCouponsByCompany(Number(companyId))
        .then((data) => data && setCoupons(data))
        .catch((err) => console.error(err));
    }
  }, []);

  return (
    <>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Title
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Description
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  StartDate
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  EndDate
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Amount
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Price
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Company
                </Typography>
              </TableCell>
              <TableCell variant="head">
                <Typography variant="body1" fontWeight="700">
                  Category
                </Typography>
              </TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {coupons.map((coupon) => (
              <TableRow key={coupon.id}>
                <TableCell variant="body" key={`title-${coupon.title}`}>
                  <Typography variant="body1">{coupon.title}</Typography>
                </TableCell>
                <TableCell variant="body" key={`description-${coupon.id}`}>
                  <Typography variant="body1">{coupon.description}</Typography>
                </TableCell>
                <TableCell variant="body" key={`startDate-${coupon.id}`}>
                  <Typography variant="body1">
                    {coupon.startDate?.toDateString()}
                  </Typography>
                </TableCell>
                <TableCell variant="body" key={`endDate-${coupon.id}`}>
                  <Typography variant="body1">
                    {coupon.endDate?.toDateString()}
                  </Typography>
                </TableCell>
                <TableCell variant="body" key={`amount-${coupon.id}`}>
                  <Typography variant="body1">{coupon.amount}</Typography>
                </TableCell>
                <TableCell variant="body" key={`price-${coupon.id}`}>
                  <Typography variant="body1">{coupon.price}</Typography>
                </TableCell>
                <TableCell variant="body" key={`company-${coupon.id}`}>
                  <Typography variant="body1">
                    {coupon.company?.name}
                  </Typography>
                </TableCell>
                <TableCell variant="body" key={`category-${coupon.id}`}>
                  <Typography variant="body1">
                    {coupon.category?.name}
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
