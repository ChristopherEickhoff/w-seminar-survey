package de.chris.w_seminar_survey.survey;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SurveyResult {

    /*
     *     age: age.value,
    sex: sex.value,
    plz: plz.value,
    residential_area: residential_area.value,
    school_education: school_education.value,
    monthly_income: monthly_income.value,
    public_transportation_availability: public_transportation_availability.value,
    main_transportation_means: main_transportation_means.value,
    public_transportation_usage: public_transportation_usage.value,
    regional_and_seasonal_food: regional_and_seasonal_food.value,
    vegetarian_or_vegan_diet: vegetarian_or_vegan_diet.value,
    avoid_flying: avoid_flying.value,
    use_secondhand_or_durable_products: use_secondhand_or_durable_products.value,
    save_energy_at_home: save_energy_at_home.value,
    separate_waste: separate_waste.value,
    shop_plastic_free: shop_plastic_free.value,
    additional_information: additional_information.value
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String age;
    private String sex;
    private String plz;
    private String residential_area;
    private String school_education;
    private String monthly_income;
    
    private String public_transportation_availability;
    private String main_transportation_means;
    private String public_transportation_usage;
    
    private int regional_and_seasonal_food;
    private int vegetarian_or_vegan_diet;
    private int avoid_flying;
    private int use_secondhand_or_durable_products;
    private int save_energy_at_home;
    private int separate_waste;
    private int shop_plastic_free;
    
    private String additional_information;

    public SurveyResult() {
    }

    public SurveyResult(String age, String sex, String plz, String residential_area, String school_education, String monthly_income, 
    String public_transportation_availability, String main_transportation_means, String public_transportation_usage, 
    int regional_and_seasonal_food, int vegetarian_or_vegan_diet, int avoid_flying, int use_secondhand_or_durable_products, 
    int save_energy_at_home, int separate_waste, int shop_plastic_free, String additional_information) {
        this.age = age;
        this.sex = sex;
        this.plz = plz;
        this.residential_area = residential_area;
        this.school_education = school_education;
        this.monthly_income = monthly_income;
        this.public_transportation_availability = public_transportation_availability;
        this.main_transportation_means = main_transportation_means;
        this.public_transportation_usage = public_transportation_usage;
        this.regional_and_seasonal_food = regional_and_seasonal_food;
        this.vegetarian_or_vegan_diet = vegetarian_or_vegan_diet;
        this.avoid_flying = avoid_flying;
        this.use_secondhand_or_durable_products = use_secondhand_or_durable_products;
        this.save_energy_at_home = save_energy_at_home;
        this.separate_waste = separate_waste;
        this.shop_plastic_free = shop_plastic_free;
        this.additional_information = additional_information;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }
    public String getResidential_area() {
        return residential_area;
    }

    public void setResidential_area(String residential_area) {
        this.residential_area = residential_area;
    }

    public String getSchool_education() {
        return school_education;
    }

    public void setSchool_education(String school_education) {
        this.school_education = school_education;
    }

    public String getMonthly_income() {
        return monthly_income;
    }

    public void setMonthly_income(String monthly_income) {
        this.monthly_income = monthly_income;
    }

    public String getPublic_transportation_availability() {
        return public_transportation_availability;
    }

    public void setPublic_transportation_availability(String public_transportation_availability) {
        this.public_transportation_availability = public_transportation_availability;
    }

    public String getMain_transportation_means() {
        return main_transportation_means;
    }

    public void setMain_transportation_means(String main_transportation_means) {
        this.main_transportation_means = main_transportation_means;
    }

    public String getPublic_transportation_usage() {
        return public_transportation_usage;
    }

    public void setPublic_transportation_usage(String public_transportation_usage) {
        this.public_transportation_usage = public_transportation_usage;
    }

    public int getRegional_and_seasonal_food() {
        return regional_and_seasonal_food;
    }

    public void setRegional_and_seasonal_food(int regional_and_seasonal_food) {
        this.regional_and_seasonal_food = regional_and_seasonal_food;
    }

    public int getVegetarian_or_vegan_diet() {
        return vegetarian_or_vegan_diet;
    }

    public void setVegetarian_or_vegan_diet(int vegetarian_or_vegan_diet) {
        this.vegetarian_or_vegan_diet = vegetarian_or_vegan_diet;
    }

    public int getAvoid_flying() {
        return avoid_flying;
    }

    public void setAvoid_flying(int avoid_flying) {
        this.avoid_flying = avoid_flying;
    }

    public int getUse_secondhand_or_durable_products() {
        return use_secondhand_or_durable_products;
    }

    public void setUse_secondhand_or_durable_products(int use_secondhand_or_durable_products) {
        this.use_secondhand_or_durable_products = use_secondhand_or_durable_products;
    }

    public int getSave_energy_at_home() {
        return save_energy_at_home;
    }

    public void setSave_energy_at_home(int save_energy_at_home) {
        this.save_energy_at_home = save_energy_at_home;
    }

    public int getSeparate_waste() {
        return separate_waste;
    }

    public void setSeparate_waste(int separate_waste) {
        this.separate_waste = separate_waste;
    }

    public int getShop_plastic_free() {
        return shop_plastic_free;
    }

    public void setShop_plastic_free(int shop_plastic_free) {
        this.shop_plastic_free = shop_plastic_free;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }



}