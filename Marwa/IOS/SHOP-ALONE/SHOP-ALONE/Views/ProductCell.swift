//
//  ProductCell.swift
//  SHOP-ALONE
//
//  Created by Marwa Zabara on 8/13/18.
//  Copyright © 2018 Marwa Zabara. All rights reserved.
//

import UIKit

class ProductCell: UICollectionViewCell {
    @IBOutlet weak var Img : UIImageView!
    @IBOutlet weak var Title : UILabel!
    @IBOutlet weak var Price : UILabel!

    func UpdateViews(Product : Product) {
        Title.text = Product.Title
        Img.image = UIImage(named:Product.ImageName)
        Price.text = Product.Price
    }
}
