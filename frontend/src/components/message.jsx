import axios from "axios";
import {useState} from "react";


function Message() {

    const uploadState = <div className={"bg-primary"}>Uploading...</div>
    const succedState = <div className={"bg-success"}>Uploading good!</div>
    const failedState = <div className={"bg-danger"}>Uploading failed!</div>

    const [messageState, setState] = useState(-1)

    function sendMessage(){
        const userNameDoc = document.getElementById("inputUserName")
        const balanceDoc = document.getElementById("exampleInputEmail1")
        setState(0)
        console.log(userNameDoc.value)
        console.log(balanceDoc.value)
        axios({
            method: 'post',
            url: 'http://localhost:8080/api/v1/create_user',
            data: {
                username: userNameDoc.value,
                balance: Number.parseInt(balanceDoc.value)
            }
        }).then( (response) => {
            console.log(response.data)
            if(response.status === 200){
                setState(200)
            }
        }).catch((error) => {
            console.log(error.data)
            if(error.status === 400){
                setState(400)
            }
        });
    }

    return (
        <>
            <form>
                <div className="mb-3">
                    <label htmlFor="inputUserName" className="form-label">Send message to the server</label>
                    <input type="text" className="form-control" id="inputUserName" aria-describedby="inputName"/>
                </div>
                <div className="mb-3">
                    <label htmlFor="exampleInputEmail1" className="form-label">Send message to the server</label>
                    <input type="text" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
                </div>

                <button type="button" className="btn btn-primary" onClick={sendMessage}>Submit</button>
            </form>
            {
                messageState === 0 && uploadState
            }
            {
                messageState === 200 && succedState
            }
            {
                messageState === 400 && failedState
            }
        </>
    )
}

export default Message
