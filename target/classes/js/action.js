let btn = document.getElementById('buttonB');

btn.addEventListener('click',() =>{
    let numbers = document.getElementById('numbers').value;
    axios.post('http://fathomless-bayou-96611.herokuapp.com/calculate', numbers)
        .then(res => {
            doPost(res);
        })
        .catch( error =>{
            console.log(error);
        })
    axios.post('http://localhost:5000/calculate', numbers)
        .then(res => {
            doPost(res);
        })
        .catch( error =>{
            console.log(error);
        })
    function doPost(res) {
        $('.mean').html('');
        $('.std').html('');
        let data = JSON.parse(res.data);
        $(".mean").append( "Arithmetic mean: " + data.mean );
        $(".std").append( "Standard Deviation :" + data.std);
    }
});