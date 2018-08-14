//
//  ProductsVC.swift
//  SHOP-ALONE
//
//  Created by Marwa Zabara on 8/14/18.
//  Copyright © 2018 Marwa Zabara. All rights reserved.
//

import UIKit

class ProductsVC: UIViewController,UICollectionViewDelegate,UICollectionViewDataSource {
  
    @IBOutlet weak var ProductsCollection : UICollectionView!

    private(set) public var products = [Product]()
    override func viewDidLoad() {
        super.viewDidLoad()
        ProductsCollection.delegate = self
        ProductsCollection.dataSource = self

    }

    func initProducts(Category:Category) {
        products = DataService.instance.GetProducts(Category: Category.Title)
        navigationItem.title = Category.Title
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return products.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        if let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "ProductCell", for: indexPath) as? ProductCell{
        let product = products[indexPath.row]
        cell.UpdateViews(Product: product)
            return cell
        }
        return ProductCell()
    }

}
