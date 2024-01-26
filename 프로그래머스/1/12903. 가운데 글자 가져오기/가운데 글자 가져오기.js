function solution(s) {
    if(s.length % 2 !== 0){
       return( s[Math.floor(s.length/2)])
    } else {
        return (s.substr(Math.floor(s.length/2)-1,2))
    }
}