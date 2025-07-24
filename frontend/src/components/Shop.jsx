import {useEffect, useState} from "react";
import axios from "axios";


function Shop(){
    const [items, setItems] = useState([]);


    useEffect(()=>{

            axios({
                method: "GET",
                url:"http://localhost:8080/api/open/products"
            }).then((response) => {
                const data = response.data;
                console.log(data);
                setItems(data);
            })


    }, []);

    return (
            <div className="row row-cols-1 row-cols-md-3 g-4">
                {
                    items.map((value) => (
                        <div className="col">
                            <div className="card h-100">
                                <img src={value.image} className="card-img-top" alt="..." width="200px" height="200px"/>
                                <div className="card-body">
                                    <h5 className="card-title">{value.title}</h5>
                                    <p className="card-text">{value.description}</p>
                                    <h5 className="card-title">Price: {value.price}</h5>
                                </div>
                            </div>
                        </div>
                    ))
                }
            </div>


    )
}

export default Shop;