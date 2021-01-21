import React, { useState, useEffect } from "react";
import { Text, TextInput, View, StyleSheet, Button, AsyncStorage, TouchableOpacity } from "react-native";

const Login = ({ navigation }) => {
    const [username, setUserName] = useState("");
    const [pass, setPass] = useState("");

    const login = async () => {
        await AsyncStorage.setItem("username", username);
        await AsyncStorage.setItem("upassword", pass);
        navigation.navigate("Todos"); 
    }

    return (
        <View style={styles.container}>
            <Text style={styles.loginTextStyle}>Enter Details</Text>
            <TextInput style={styles.textInputStyle} onChangeText={(text) => setUserName(text)} placeholder="Username" />
            <TextInput style={styles.textInputStyle} onChangeText={(text) => setPass(text)} placeholder="Password" />
            <TouchableOpacity onPress={login} style={styles.loginBtn}>
                <Text style={styles.logText}>Save</Text>
            </TouchableOpacity>
        </View>
    )
}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center"
    },
    loginTextStyle: {
        fontSize: 25,
        fontWeight: "600",
        marginVertical: 20
    },
    loginBtn: {
        borderWidth: 2,
        borderColor: "#5301ad",
        backgroundColor: '#8e3cbb',
        width: 80,
        height: 45,
        borderRadius: 10,
        padding: 10
    },
    logText: {
        color: 'white',

        textAlign: 'center'
    },
    textInputStyle: {
        borderColor: "#000",
        borderWidth: 1,
        borderRadius: 5,
        fontSize: 20,
        padding: 5,
        width: "60%",
        marginBottom: 20
    }
})

export default Login;