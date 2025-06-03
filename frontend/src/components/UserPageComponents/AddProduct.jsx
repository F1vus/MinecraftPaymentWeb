
import axios from "axios";
import {useState} from "react";

export default function AddProductForm(){

    const [product, setProduct] = useState({
        title: "",
        description: "",
        urlimage: "",
        minecraftTag: "",
        price: ""
    });

    const [errors, setErrors] = useState({});

    const validate = () => {
        const validationErrors = {};
        if (product.title.trim() === '') {
            validationErrors.title = 'Title is required!';
        }
        if (product.description.trim() === '') {
            validationErrors.description = 'Description is required!';
        }
        if (product.urlimage.trim() === '') {
            validationErrors.urlimage = 'Url image is required!';
        }
        if (product.minecraftTag.trim() === '') {
            validationErrors.minecraftTag = 'Minecraft tag is required!';
        }
        let num = Number.parseInt(product.price.trim());
        if(isNaN(num) || num <= 0){
            validationErrors.price = 'Price must be > 0 or its not integer';
        }
        return Object.keys(validationErrors).length === 0 ? null :
            validationErrors;
    };

    const handleChange = (event) => {
        const {name, value} = event.target;
        setProduct((prevProduct) => ({
            ...prevProduct,
            [name]: value
        }));
        console.log(product)
    };

    async function sendAddProductRequest(event){

        event.preventDefault();
        const validationErrors = validate();
        setErrors(validationErrors || {});
        if (validationErrors) return;


        await axios({
            method: 'post',
            url: 'http://localhost:8080/secured/api/v1/add_product',
            headers: {
                "Authorization" : 'Bearer '+localStorage.getItem("token")
            },
            data: {
                title: product.title,
                description: product.description,
                urlimage: product.urlimage,
                minecraftTag: product.minecraftTag,
                price: Number.parseInt(product.price),
            }
        }).then( (response) => {
            console.log(response.data)
            if(response.status === 200){
                setErrors({
                    status: 200
                });
            }
        }).catch((error) => {
            console.log(error.data)
            setErrors({
                status: 400
            });
        });
    }

    return (
        <>
            <form onSubmit={sendAddProductRequest} className="form-control">
                <div className="mb-3">
                    <label>Title(must be unique)</label>
                    <input
                        value={product.title}
                        name="title"
                        onChange={handleChange}
                        type="text"
                        className="form-control"
                        id="title"
                        aria-describedby="emailHelp"
                        placeholder="title"
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Description</label>
                    <textarea
                        value={product.description}
                        name="description"
                        onChange={handleChange}
                        className="form-control"
                        id="description"
                        aria-describedby="emailHelp"
                        rows="3"
                    >
                    </textarea>
                </div>
                <div className="mb-3">
                    <label>Url image</label>
                    <input
                        value={product.urlimage}
                        name="urlimage"
                        onChange={handleChange}
                        type="text"
                        className="form-control"
                        id="urlimage"
                        aria-describedby="emailHelp"
                        placeholder="url image"
                    />
                </div>
                <div className="mb-3">
                    <label>Minecraft Tag</label>
                    <input
                        value={product.minecraftTag}
                        name="minecraftTag"
                        onChange={handleChange}
                        type="text"
                        className="form-control"
                        id="minecraftTag"
                        aria-describedby="emailHelp"
                        placeholder="minecraft tag"
                    />
                </div>
                <div className="mb-3">
                    <label>Price</label>
                    <input
                        value={product.price}
                        name="price"
                        onChange={handleChange}
                        type="text"
                        className="form-control"
                        id="price"
                        aria-describedby="emailHelp"
                        placeholder="product price"
                    />
                </div>
                {
                    (errors.price || errors.minecraftTag || errors.urlimage || errors.description ||  errors.title) && (
                        <div className="alert alert-danger">Fields cant not be empty </div>
                    )
                }
                <button type="submit" className="btn btn-primary">Submit</button>
                {
                    errors.status === 200 && (
                        <div className="alert alert-success">Product added!</div>
                    )
                }
                {
                    errors.status === 400 && (
                        <div className="alert alert-danger">{errors.status}</div>
                    )
                }
            </form>
        </>

    )
}