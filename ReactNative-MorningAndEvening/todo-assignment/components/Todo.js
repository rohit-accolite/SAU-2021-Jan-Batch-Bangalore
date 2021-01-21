import React from 'react';
import { StyleSheet, Text, View, TextInput, ScrollView, TouchableOpacity } from 'react-native';
import Note from './Note.js';

export default class Todo extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            todoArray: [],
            todoText: ''
        }
    }

    render() {

        let todos = this.state.todoArray.map((val, key) => {
            return <Note key={key} keyval={key} val={val}
                deleteMethod={() => this.deleteNote(key)}
            />
        })


        return (
            <View style={styles.container}>
                <View style={styles.header}>
                    <Text style={styles.headerText}>TODO APP</Text>
                </View>

                <ScrollView style={styles.scrollContainer}>
                    {todos}
                </ScrollView>

                <View style={styles.footer}>
                    <TextInput
                        style={styles.textInput}
                        onChangeText={(todoText) => this.setState({ todoText })}
                        value={this.state.todoText}
                        placeholder='Todo'
                        placeholderTextColor='white'
                        underlineColorAndroid='transparent'>
                    </TextInput>
                </View>

                <TouchableOpacity onPress={this.addTodo.bind(this)} style={styles.addButton}>
                    <Text style={styles.addButtonText}>+</Text>
                </TouchableOpacity>

            </View>
        );
    }
    addTodo() {
        if (this.state.todoText) {
            var date = new Date();

            this.state.todoArray.push({
               'todo':this.state.todoText
            });

            this.setState({todoArray: this.state.todoArray});
            this.setState({todoText:this.state.todoText});
        }

    }

    deleteNote(key){
        this.state.todoArray.splice(key,1);
        this.setState({todoArray:this.state.todoArray});
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    header: {
        backgroundColor: '#8e3cbb',
        alignItems: 'center',
        justifyContent: 'center',
        borderBottomWidth: 10,
        borderBottomColor: '#ddd',
    },
    headerText: {
        color: 'white',
        fontSize: 18,
        padding: 26,
    },
    scrollContainer: {
        flex: 1,
        marginBottom: 100,
    },
    footer: {
        position: 'absolute',
        bottom: 0,
        left: 0,
        right: 0,
        zIndex: 10,
    },
    textInput: {
        alignSelf: 'stretch',
        color: '#fff',
        padding: 20,
        backgroundColor: '#252525',
        borderTopWidth: 2,
        borderTopColor: '#ededed',
    },
    addButton: {
        position: 'absolute',
        zIndex: 11,
        right: 20,
        bottom: 90,
        backgroundColor: '#8e3cbb',
        width: 70,
        height: 70,
        borderRadius: 50,
        alignItems: 'center',
        justifyContent: 'center',
        elevation: 8,
    },
    addButtonText: {
        color: '#fff',
        fontSize: 30
    },
});
