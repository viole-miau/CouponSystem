import BaseController from "./BaseController";
import Coupon from "../models/Coupon";
import Company from "../models/Company";
import Category from "../models/Category";

export default class CompanyController extends BaseController {
  constructor() {
    const baseUrl: string = "company/";
    super(baseUrl);
  }

  async addCoupon(coupon: Omit<Coupon, "id">) {
    try {
      const response = await this.instance.post("addCoupon", {
        title: coupon.title,
        description: coupon.description,
        startDate: coupon.startDate,
        endDate: coupon.endDate,
        amount: coupon.amount,
        price: coupon.price,
        company: coupon.company,
        category: coupon.category,
      });
      console.log(response);
    } catch (err) {
      console.error(err);
    }
  }

  async updateCoupon(coupon: Coupon) {
    try {
      const response = await this.instance.post(`updateCoupon/${coupon.id}`, {
        title: coupon.title,
        description: coupon.description,
        startDate: coupon.startDate,
        endDate: coupon.endDate,
        amount: coupon.amount,
        price: coupon.price,
        company: coupon.company,
        category: coupon.category,
      });
      console.log(response);
    } catch (err) {
      console.error(err);
    }
  }

  async deleteCoupon(coupon: Pick<Required<Coupon>, "id">) {
    try {
      const response = await this.instance.delete(`deleteCoupon/${coupon.id}`);
      console.log(response);
    } catch (err) {
      console.error(err);
    }
  }

  async getCompanyCoupons(
    company: Pick<Required<Company>, "id">
  ): Promise<Coupon[]> {
    try {
      const couponsData = (
        await this.instance.get<Coupon[]>(`getCompanyCoupons/${company.id}`)
      ).data;
      return couponsData;
    } catch (err) {
      throw err;
    }
  }

  async getCompanyCouponsByMaxPrice(
    company: Pick<Required<Company>, "id">,
    maxPrice: number
  ): Promise<void> {
    try {
      const couponsData = (
        await this.instance.get<Coupon[]>(
          `getCompanyCouponsByMaxPrice/${company.id}`,
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

  async getCompanyCouponsByCategory(
    company: Pick<Required<Company>, "id">,
    category: Pick<Required<Category>, "id">
  ): Promise<void> {
    try {
      const couponsData = (
        await this.instance.get<Coupon[]>(
          `getCompanyCouponsByCategory/${company.id}`,
          {
            params: {
              categoryId: category.id,
            },
          }
        )
      ).data;
      console.log(couponsData);
    } catch (err) {
      console.error(err);
    }
  }

  async getCompanyDetails(
    company: Pick<Required<Company>, "id">
  ): Promise<void> {
    try {
      const companyData = (
        await this.instance.get<Company>(`getCompanyDetails/${company.id}`)
      ).data;
      console.log(companyData);
    } catch (err) {
      console.error(err);
    }
  }
}

export function getCouponsByCompany(companyId: number) {
  const controller = new CompanyController();
  return controller
    .getCompanyCoupons({ id: companyId })
    .then((result) => result)
    .catch((err) => console.log(err));
}

export function getCouponsByCompanyByMaxPrice(
  companyId: number,
  maxPrice: number
) {
  const controller = new CompanyController();
  return controller
    .getCompanyCouponsByMaxPrice(
      {
        id: companyId,
      },
      maxPrice
    )
    .then((result) => result)
    .catch((err) => console.log(err));
}

export function getCouponsByCompanyByCategory(
  companyId: number,
  categoryId: number
) {
  const controller = new CompanyController();
  return controller
    .getCompanyCouponsByCategory({ id: companyId }, { id: categoryId })
    .then((result) => result)
    .catch((err) => console.log(err));
}
