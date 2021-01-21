import React from 'react';
import Todo from './components/Todo.js';
import Login from './components/Login.js';

import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';

const Stack = createStackNavigator();

export default class App extends React.Component {
  render(){
    return (
      <NavigationContainer>
        <Stack.Navigator>
          <Stack.Screen name="Login" component={Login} />
          <Stack.Screen name="Todos" component={Todo} />
        </Stack.Navigator>
      </NavigationContainer>
    );
  }
}
