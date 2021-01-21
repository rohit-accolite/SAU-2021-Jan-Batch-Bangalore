import React from 'react';
import { StyleSheet, Text, View, TouchableOpacity } from 'react-native';

export default class Note extends React.Component {
    render() {
        return (
            <View key={this.props.keyval} style={styles.note}>
                <Text style={styles.noteText}>{this.props.val.todo}</Text>
                <TouchableOpacity onPress={this.props.deleteMethod} style={styles.noteDelete}>
                    <Text style={styles.noteDeleteText}>X</Text>
                </TouchableOpacity>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    note: {
        position: 'relative',
        padding: 20,
        marginTop:5,
        paddingRight: 100,
        borderWidth: 2,
        borderColor: '#000',
    },
    noteText: {
        fontSize: 18
    },
    noteDelete: {
        position: 'absolute',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#db281f',
        width: 50,
        height: 50,
        borderRadius: 50,
        padding: 10,
        top: 10,
        bottom: 10,
        right: 10
    },
    noteDeleteText: {
        color: 'white',
    }
})