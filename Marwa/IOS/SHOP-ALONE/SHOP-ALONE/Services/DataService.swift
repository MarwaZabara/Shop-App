//
//  DataService.swift
//  SHOP-ALONE
//
//  Created by Marwa Zabara on 8/5/18.
//  Copyright © 2018 Marwa Zabara. All rights reserved.
//

import Foundation

struct DataService {
    static let instance = DataService()
    private let Categories = [
        Category(Title: "HATS", ImageName: "hats.png"),
        Category(Title: "SHIRTS", ImageName: "shirts.png"),
        Category(Title: "HOODIES", ImageName: "hoodies.png"),
        Category(Title: "DIGITAL", ImageName: "digital.png")
    ]
    
    
   private let hats = [
    Product(ImageName: "hat01", Price: "30$", Title: "Special hat"),
    Product(ImageName: "hat02", Price: "90$", Title: "Fancy hat"),
    Product(ImageName: "hat03", Price: "45$", Title: "Best hat in stock"),
    Product(ImageName: "hat04", Price: "56$", Title: "hatty hat")
]
    private let shirts = [
        Product(ImageName: "shirt01", Price: "30$", Title: "Special Shirt"),
        Product(ImageName: "shirt02", Price: "90$", Title: "Casual every day use shirt"),
        Product(ImageName: "shirt03", Price: "45$", Title: "Best seller in stock"),
        Product(ImageName: "shirt04", Price: "56$", Title: "School shirt"),
          Product(ImageName: "shirt05", Price: "20$", Title: "School days shirt")
    ]
    private let hoodies = [
        Product(ImageName: "hoodie01", Price: "30$", Title: "Special offered Hoodie"),
        Product(ImageName: "hoodie02", Price: "90$", Title: "Casual every day Hoodie"),
        Product(ImageName: "hoodie03", Price: "45$", Title: "Best seller in stock"),
        Product(ImageName: "hoodie04", Price: "56$", Title: "Best School Hoodie")
    ]

    private let digitals = [Product]()
    
    func GetProducts(Category:String) -> [Product]{
        switch Category {
        case "HATS":
            return GetHats()
        case "SHIRTS":
            return GetShirts()
        case "HOODIES":
           return GetHoodeis()
        case "DIGITAL":
            return GetDigitals()
        default:
            return [Product]()
        }
    }
    
    func GetHats() ->[Product]{
        return hats
    }
    func GetShirts() ->[Product]{
        return shirts
    }
    func GetHoodeis() ->[Product]{
        return hoodies
    }
    func GetDigitals() ->[Product]{
        return digitals
    }
    
    
    func GetCategories() ->[Category]{
        return Categories
    }
    
    
}
