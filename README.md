# AndroidEdgeToEdge

## Overview
This project demonstrates various approaches to implementing Edge-to-Edge support in Android applications using Jetpack Compose. Edge-to-Edge design allows your app's content to extend behind the system bars (status bar and navigation bar), creating a more immersive user experience.

## Purpose
The main purpose of this project is to showcase and compare different Modifier approaches for handling system insets in Edge-to-Edge implementations. By providing multiple examples with different techniques, developers can understand the nuances of each approach and choose the most appropriate one for their specific use case.

## Edge-to-Edge Implementation Approaches
This project demonstrates the following approaches:

### 1. Insets Function Approach
Uses the convenience extension functions directly:
- `statusBarsPadding()` - Adds padding to accommodate the status bar
- `navigationBarsPadding()` - Adds padding to accommodate the navigation bar

### 2. Insets Modifier Approach
Uses the `windowInsetsPadding()` modifier with specific WindowInsets:
- `windowInsetsPadding(WindowInsets.statusBars)`
- `windowInsetsPadding(WindowInsets.navigationBars)`

### 3. Padding Modifier Approach
Converts WindowInsets to PaddingValues and uses the standard padding modifier:
- `padding(WindowInsets.statusBars.asPaddingValues())`
- `padding(WindowInsets.navigationBars.asPaddingValues())`

### 4. Consuming Insets
Demonstrates how to consume insets at a specific level in the component hierarchy:
- `consumeWindowInsets(WindowInsets.statusBars)`
- `consumeWindowInsets(WindowInsets.navigationBars)`

## Screens

### Home Screen
The main navigation hub that provides access to all demonstration screens.

### Scrollable Screens
Demonstrate how to apply insets to scrollable content:
- **INSETS_FUNC_SCROLLABLE**: Uses insets function approach with scrollable content
- **INSETS_MODIFIER_SCROLLABLE**: Uses insets modifier approach with scrollable content
- **PADDING_MODIFIER_SCROLLABLE**: Uses padding modifier approach with scrollable content

### Nested Screens
Demonstrate how insets are applied and propagated in nested component hierarchies:
- **INSETS_FUNC_NEST**: Uses insets function approach with nested boxes
- **INSETS_MODIFIER_NEST**: Uses insets modifier approach with nested boxes
- **PADDING_MODIFIER_NEST**: Uses padding modifier approach with nested boxes

### Consume Screen
Demonstrates how to consume insets at a specific level in the component hierarchy.

## Visual Indicators
Each screen uses different background colors to help visualize how the insets are applied:
- Different colored backgrounds show the boundaries of each component
- Semi-transparent colors allow you to see how components overlap
- The order of modifiers affects how the insets are applied

## Getting Started
1. Clone the repository
2. Open the project in Android Studio
3. Run the app on a device or emulator
4. Navigate through the different screens to see how each approach handles Edge-to-Edge implementation

## Implementation Details
The project uses:
- Jetpack Compose for the UI
- `enableEdgeToEdge()` from the Activity API to enable Edge-to-Edge mode
- Various Modifier approaches to handle system insets
