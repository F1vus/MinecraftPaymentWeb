import {useEffect, useState} from "react";
import axios from "axios";

function Shop(){
    const [items, setItems] = useState();

    async function fetchProducts(){
        await axios({
            method: "GET",
            url:"http://localhost:8080/api/v1/products"
        }).then((response) => {
            const data = response.data;
            console.log(data);
            setItems(data);
        })
    }

    useEffect(()=>{
        fetchProducts();
    }, []);

    return (
        <>

        </>
    )
}

export default Shop;