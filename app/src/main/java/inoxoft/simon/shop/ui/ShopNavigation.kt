package inoxoft.simon.shop.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import inoxoft.simon.shop.ui.pages.CashFlow
import inoxoft.simon.shop.ui.pages.CashManager
import inoxoft.simon.shop.ui.pages.DebtManager
import inoxoft.simon.shop.viewmodel.cash.CashViewModel
import inoxoft.simon.shop.viewmodel.stock.StockViewModel

@Composable
fun ShopNavigation(
    modifier: Modifier = Modifier,
    viewModel: StockViewModel,
    cashViewModel: CashViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "cashflow", builder = {
        composable("cashflow") { CashFlow(modifier,navController,viewModel) }
        composable("cashmanager") { CashManager(modifier,navController,cashViewModel) }
        composable("debtmanager"){ DebtManager()}
    })
}