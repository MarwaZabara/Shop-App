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
    let Categories = [
        Category(Title: "HATS", ImageName: "hats.png"),
        Category(Title: "SHIRTS", ImageName: "shirts.png"),
        Category(Title: "HOODIES", ImageName: "hoodies.png"),
        Category(Title: "DIGITAL", ImageName: "digital.png")
    ]
    
    func GetCategories() ->[Category]{
        return Categories
    }
    
    
}
