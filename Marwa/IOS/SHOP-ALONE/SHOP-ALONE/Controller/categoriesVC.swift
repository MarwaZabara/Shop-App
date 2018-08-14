//
//  ViewController.swift
//  SHOP-ALONE
//
//  Created by Marwa Zabara on 8/5/18.
//  Copyright © 2018 Marwa Zabara. All rights reserved.
//

import UIKit

class CategoriesVC: UIViewController , UITableViewDelegate,UITableViewDataSource{
    @IBOutlet weak var CategoriesTable: UITableView!
    
 
    
    override func viewDidLoad() {
        super.viewDidLoad()
        CategoriesTable.dataSource = self
        CategoriesTable.delegate = self
//       // CategoriesTable.rowHeight = UITableViewAutomaticDimension
//        CategoriesTable.estimatedRowHeight = 200
//       CategoriesTable.reloadData()

        
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return DataService.instance.GetCategories().count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if let cell = tableView.dequeueReusableCell(withIdentifier: "CategoryCell") as? CategoryCell{
        let Category = DataService.instance.GetCategories()[indexPath.row]
        cell.UpdateViews(Category: Category)
        return cell}
    return CategoryCell()
    
    }
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 200
    }
  
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
       let Category = DataService.instance.GetCategories()[indexPath.row]
        performSegue(withIdentifier: "ProductsVC", sender: Category)
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let ProductsVC = segue.destination as? ProductsVC{
            assert(sender as? Category != nil)
            ProductsVC.initProducts(Category: sender as! Category)
            let BarBtn = UIBarButtonItem()
            BarBtn.title=""
            navigationItem.backBarButtonItem = BarBtn
        }}

}

