function solution(price, money, count) {
    // n번째 이용료 : price*count
    // 총 이용료 price *(1+2+... + count번)``
    //price*reduce
    
    let sum = 0;
    for (let i=1; i<=count; i++){  
         sum += i  
   }
    const allPrice = price*sum;
    // console.log(allPrice)
    let restMoney = allPrice-money
    if(restMoney > 0){
        return restMoney
    } else {
        return 0
    }
    
    
    

    
}