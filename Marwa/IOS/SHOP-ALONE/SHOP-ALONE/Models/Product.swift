//
//  Product.swift
//  SHOP-ALONE
//
//  Created by Marwa Zabara on 8/13/18.
//  Copyright © 2018 Marwa Zabara. All rights reserved.
//

import Foundation

struct Product {
    private(set) public var ImageName : String
    private(set) public var Price : String
    private(set) public var Title : String

    
    init(ImageName:String,Price:String,Title:String) {
        self.ImageName = ImageName
        self.Price = Price
        self.Title = Title
    }

}
