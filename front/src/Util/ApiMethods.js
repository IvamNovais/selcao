import api from "./Api.js"

async function getToken(){
        const token = await api.post("/oauth/token",{
        auth: {
            Username: 'Bam',
            Password: '123'
         },
         grant_type: "password",
         Username: 'Doug',
        Password: '123'

    })
    console.log(token)
    return token
}
export default getToken