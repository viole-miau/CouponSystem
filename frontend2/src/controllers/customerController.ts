import BaseController from "./BaseController";
import Coupon from "../models/Coupon";
import Customer from "../models/Customer";
import Category from "../models/Category";
import { Console } from "console";

export default class CustomerController extends BaseController {
  constructor() {
    const baseUrl: string = "customer/";
    super(baseUrl);
  }

  async addPurchase(
    coupon: Pick<Required<Coupon>, "id">,
    customer: Pick<Required<Customer>, "id">
  ) {
    try {
      const response = await this.instance.post("addPurchase", {
        coupon: {
          id: coupon.id,
        },
        customer: {
          id: customer.id,
        },
      });
      console.log(response);
    } catch (err) {
      console.error(err);
    }
  }

  async getCustomerCoupons(
    customer: Pick<Required<Customer>, "id">
  ): Promise<Coupon[]> {
    try {
      const couponsData = (
        await this.instance.get<Coupon[]>(`getCustomerCoupons/${customer.id}`)
      ).data;
      return couponsData;
    } catch (err) {
      throw err;
    }
  }

  async getCustomerCouponsByMaxPrice(
    customer: Pick<Required<Customer>, "id">,
    maxPrice: number
  ): Promise<void> {
    try {
      const couponsData = (
        await this.instance.get<Coupon[]>(
          `getCustomerCouponsByMaxPrice/${customer.id}`,
          {
            params: {
              maxPrice,
            },
          }
        )
      ).data;
      console.log(couponsData);
    } catch (err) {
      console.error(err);
    }
  }

  async getCustomerCouponsByCategory(
    customer: Pick<Required<Customer>, "id">,
    category: Pick<Required<Category>, "id">
  ): Promise<Coupon[]> {
    try {
      const couponsData = (
        await this.instance.get<Coupon[]>(
          `getCustomerCouponsByCategory/${customer.id}`,
          {
            params: {
              categoryId: category.id,
            },
          }
        )
      ).data;
      return couponsData;
    } catch (err) {
      throw err;
    }
  }

  async getCustomerDetails(
    customer: Pick<Required<Customer>, "id">
  ): Promise<void> {
    try {
      const customerData = (
        await this.instance.get<Customer>(`getCustomerDetails/${customer.id}`)
      ).data;
      console.log(customerData);
    } catch (err) {
      console.error(err);
    }
  }
}

export function getCouponsByCustomer(customerId: number) {
  const controller = new CustomerController();
  return controller
    .getCustomerCoupons({
      id: customerId,
    })
    .then((result) => result)
    .catch((err) => console.error(err));
}

export function getCouponsByCustomerByMaxPrice(
  customerId: number,
  maxPrice: number
) {
  const controller = new CustomerController();
  return controller
    .getCustomerCouponsByMaxPrice({ id: customerId }, maxPrice)
    .then((result) => result)
    .catch((err) => console.log(err));
}

export function getCouponsByCustomerByCategory(
  customerId: number,
  categoryId: number
) {
  const controller = new CustomerController();
  return controller
    .getCustomerCouponsByCategory(
      {
        id: customerId,
      },
      {
        id: categoryId,
      }
    )
    .then((result) => result)
    .catch((err) => console.log(err));
}
