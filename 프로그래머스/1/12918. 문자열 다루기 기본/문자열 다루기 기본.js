function solution(s) {
    if(!(s.length===4 || s.length === 6)){
        return false;
    }
    
    let isNumeric = true //순정 숫자 여부
    for (let i=0; i <s.length; i++){
        let ch = s[i]
        
        if(!(ch >= 0 && ch <= 9)){ //isNan(ch)
            isNumeric = false;
            break;
        }
    }
    return isNumeric;
}