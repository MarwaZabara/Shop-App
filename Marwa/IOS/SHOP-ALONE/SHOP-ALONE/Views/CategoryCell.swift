//
//  CategoryCell.swift
//  SHOP-ALONE
//
//  Created by Marwa Zabara on 8/5/18.
//  Copyright © 2018 Marwa Zabara. All rights reserved.
//

import UIKit

class CategoryCell: UITableViewCell{
    @IBOutlet weak var Title : UILabel!
    @IBOutlet weak var Img: UIImageView!
    
    func UpdateViews(Category:Category) {
        Title.text = Category.Title
        Img.image = UIImage(named: Category.ImageName)
    }

}
