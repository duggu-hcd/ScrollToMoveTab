package duggu.scroll.tabchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var linearLayoutManager: LinearLayoutManager? = null
    private var subCatAdapter: SubCategoryAdapter? = null
    private var selectedSubCatPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val subCatModel = ArrayList<SubCategoryModel?>()
        val catModel = ArrayList<CatModel?>()

        catModel.addAll(getCatModel(oneToFive,0))
        subCatModel.add(SubCategoryModel(oneToFive,"one to five",true,0))

        subCatModel.add(SubCategoryModel(sixToten,"six to ten",false,catModel.size+1))
        catModel.addAll(getCatModel(sixToten,1))

        subCatModel.add(SubCategoryModel(eleventTofifteen,"eleven to fifteen",false,catModel.size+1))
        catModel.addAll(getCatModel(eleventTofifteen,2))

        subCatModel.add(SubCategoryModel(sixteenToTwenty,"sixteen to twenty",false,catModel.size+1))
        catModel.addAll(getCatModel(sixteenToTwenty,3))

        subCatModel.add(SubCategoryModel(twentyoneToTwentyfive,"twenty one to twenty five",false,catModel.size+1))
        catModel.addAll(getCatModel(twentyoneToTwentyfive,4))

        subCatModel.add(SubCategoryModel(twentysixToThirty,"twenty six to thrity",false,catModel.size+1))
        catModel.addAll(getCatModel(twentysixToThirty,5))

        rvSubCatAct.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                subCatAdapter = SubCategoryAdapter(subCatModel)
                adapter = subCatAdapter
        }

        linearLayoutManager = LinearLayoutManager(this)
        rvServiceList.apply {
            layoutManager = linearLayoutManager
            adapter = CategoryAdapter(catModel)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    if(isSelectSubCatScrollClick) {
                        linearLayoutManager?.let { lm ->
                            val index = lm.findFirstVisibleItemPosition()
                            if((catModel.size-1) >= index) {
                                catModel[index]?.let { sd ->
                                    if (selectedSubCatPosition != sd.index) {
                                        selectedSubCatPosition = sd.index
                                        subCatAdapter?.updateList(selectedSubCatPosition)
                                        rvSubCatAct.layoutManager?.scrollToPosition(selectedSubCatPosition)
                                    }
                                }
                            }
                        }
//                    }
                }
            })
        }

    }

    private fun getCatModel(model : ArrayList<String>,index : Int): ArrayList<CatModel> {
        val catModelList = ArrayList<CatModel>()
        model.forEach {str->
            catModelList.add(CatModel(str,index))
        }
        return catModelList
    }

    private var oneToFive = arrayListOf("1 for first tab","2 for first tab","3 for first tab","4 for first tab","5 for first tab")
    private var sixToten = arrayListOf("6 for second tab","7 for second tab","8 for second tab","9 for second tab","10 for second tab")
    private var eleventTofifteen = arrayListOf("11 for third tab","12 for third tab","13 for third tab","14 for third tab","15 for third tab")
    private var sixteenToTwenty = arrayListOf("16 for fourth tab","17 for fourth tab","18 for fourth tab","19 for fourth tab","20 for fourth tab")
    private var twentyoneToTwentyfive = arrayListOf("21 for fifth tab","22 for fifth tab","23 for fifth tab","24 for fifth tab","25 for fifth tab")
    private var twentysixToThirty = arrayListOf("26 for sixth tab","27 for sixth tab","28 for sixth tab","29 for sixth tab","30 for sixth tab")

}